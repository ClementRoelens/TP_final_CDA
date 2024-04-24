import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { getHeaders } from "../helpers/jwtHelperProvider";
import AsyncStorage from "@react-native-async-storage/async-storage";
// import Config from "react-native-config";


async function getEmployee(email){
    const headersValue = await getHeaders();
    return (await axios.get(`http://10.0.2.2:8090/api/employees/byMail/${email}`, {headers :headersValue})).data;
}


export const signin = createAsyncThunk(
    "employee/signin",
    async (credentials) => {
        const jwt = (await axios.post(`http://10.0.2.2:8090/api/employees/signin`, credentials)).data;
        await AsyncStorage.setItem("token",jwt);
        return await getEmployee(credentials.email);
    }
);


const employeeSlice = createSlice({
    name : "employee",
    initialState :{
        employee : null
    },
    reducers : {},
    extraReducers : (builder) => {
        builder.addCase(signin.fulfilled, (state,action) => {
            state.employee = action.payload;
            console.log("employé récupéré : ", state.employee);
        }),
        builder.addCase(signin.rejected, (state, action) => {
            console.error(action.error);
        })
    }
});

export default employeeSlice.reducer;