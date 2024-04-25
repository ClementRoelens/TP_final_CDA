import { configureStore } from "@reduxjs/toolkit";
import employeeSlice from "./components/employeeSlice";
import attendanceSlice from "./components/attendanceSlice";

export const store = configureStore({
    reducer : {
        employee : employeeSlice,
        attendance : attendanceSlice
     }
});