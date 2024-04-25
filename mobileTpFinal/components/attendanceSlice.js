import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { getHeaders } from "../helpers/jwtHelperProvider";
import AsyncStorage from "@react-native-async-storage/async-storage";
// import Config from "react-native-config";

export const clockIn = createAsyncThunk(
    "attendance/clockIn",
    async (credentials) => {
        console.log("clockin")
        return (await axios.post(`http://10.0.2.2:8090/api/attendance/clockIn`, credentials)).data;
        // await AsyncStorage.setItem("token", jwt);
        return await getEmployee(credentials.clockIn);
    });

export const clockOut = createAsyncThunk(
    "attendance/clockOut",
    async (credentials) => {
        console.log("clockout")
        return(await axios.post(`http://10.0.2.2:8090/api/attendance/clockOut`, credentials)).data;
        // await AsyncStorage.setItem("token", jwt);
        return await getEmployee(credentials.clockOut);
    });

export const getInitialClockInFromDatabase = createAsyncThunk(
    "attendance/geteInitialClock",
    async (employeeId) => {
        try {
            const headers = {headers : getHeaders()};
            const response = await axios.post("http://10.0.2.2:8090/api/attendance/clockIn", {id : employeeId}, );
            const data = response.data;
            console.log("getInitialClockIn", data);
            return data;
        } catch (error) {
            console.error("Erreur lors de la récupération du clockIn depuis la base de données :");
            console.error(error)
            return null;
        }
    }
);


const attendanceSlice = createSlice({
    name: "attendance",
    initialState: {
        attendance: null,
        clockIn: null,
        clockOut: null,

    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(clockIn.fulfilled, (state, action) => {
            state.clockIn = action.payload;
            console.log("heure d'arrivée : ", state.attendance);
        }),
            builder.addCase(clockOut.fulfilled, (state, action) => {
                state.clockOut = action.payload;
                console.log("heure de sortie : ", state.attendance);
            }),
            builder.addCase(clockIn.rejected, (state, action) => {
                console.error(action.error);
            }),
            builder.addCase(clockOut.rejected, (state, action) => {
                console.error(action.error);
            }),
            builder.addCase(getInitialClockInFromDatabase.fulfilled, (state,action) => {
                state.clockIn = action.payload;
            }),
            builder.addCase(getInitialClockInFromDatabase.rejected, (state, action) => {
                console.error(action.error);
            })
    }

});

export default attendanceSlice.reducer;