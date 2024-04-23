import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
// import Config from "react-native-config";



export const getEmploye = createAsyncThunk(
    "employee/get",
    async (email) => {
        return (await axios.get(`http://localhost:8090/api/employees/${id}`)).data;
    }
);

export const signin = createAsyncThunk(
    "employee/signin",
    async (credentials) => {
        const jwt = (await axios.post(`http://localhost:8090/api/employees/signin`, credentials)).data;
        return await getEmploye(credentials.email);
    }
);

const employeSlice = createSlice({
    name : "employe",
    initialState :{
        employe : null
    },
    reducers : {},
    extraReducers : (builder) => {
        builder.addCase(getEmploye.fulfilled, (state,action) => {
            state.employe = action.payload;
        }),
        builder.addCase(getEmploye.rejected, (state,action) => {
            console.error(action.error);
        }),
        builder.addCase(signin.fulfilled, (state,action) => {

        })
    }
});

export default employeSlice.reducer;