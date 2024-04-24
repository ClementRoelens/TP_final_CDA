import { configureStore } from "@reduxjs/toolkit";
import employeeSlice from "./components/employeeSlice";

export const store = configureStore({
    reducer : {
        employee : employeeSlice
     }
});