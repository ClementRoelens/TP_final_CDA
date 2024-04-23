import { configureStore } from "@reduxjs/toolkit";
import authSlice from "./components/auth/authSlice";
import employeeSlice from "./routes/employeeSlice";

const store = configureStore({
    reducer:{
        auth:authSlice,
        employees:employeeSlice
    }
})

export default store