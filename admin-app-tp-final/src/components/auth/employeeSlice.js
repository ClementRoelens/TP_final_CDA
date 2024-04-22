import { createAsyncThunk } from "@reduxjs/toolkit";

const API_Employee = "http://localhost:8080"

export const fetchEmployee = createAsyncThunk(
    "happyInHappyOut/connexion",
    async () => {
        const response = await fetch(API_Employee + )
    }
)