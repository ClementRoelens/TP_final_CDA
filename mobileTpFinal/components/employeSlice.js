import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";


export const getEmploye = createAsyncThunk(
    "employe/get",
    async (id) => {
        return (await axios.get(`${apiBaseUrl}/employe/${id}`)).data;
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
        })
    }
});

export default employeSlice.reducer;