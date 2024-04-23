import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

const API_Employee = "http://localhost:8080"

export const signInAction = createAsyncThunk(
    "auth/signInAction",
    async (credentials) => {
        const response = await fetch(API_Employee, {
            method: "Post",
            headers: {
                "Content-Type": "????"
            },
            body: JSON.stringify(credentials)
        })
        if (!response.ok) {
            throw new Error("Something went wrong when Signing in...")
          }
          const data = await response.json()

          return data
    }
)

export const signUpAction = createAsyncThunk(
    "auth/signUpAction",
    async (credentials) => {
      const response = await fetch(API_Employee, {
        method: "POST",
        headers: {
          "Content-Type": "?????"
        },
        body: JSON.stringify(credentials)
      })
  
      if (!response.ok) {
        throw new Error("Something went wrong when Signing up...")
      }
  
      const data = await response.json()
  
      return data
    }
  )

  const authSlice = createSlice({
    name: "auth",
    initialState: {
        authMode: "Se connecter",
        user : null
    },
    reducers: {
        logOutAction(state,action) {
            state.user = null
            localStorage.removeItem('token')
        },
        setAuthMode: (state, action) => {
            state.authMode = action.payload
        }
    },
    extraReducers: (builder) => {
        builder.addCase(signInAction.fulfilled, (state, action) => {
            state.user = action.payload
            localStorage.setItem('token', action.payload.idToken)
        })
        builder.addCase(signUpAction.fulfilled, (state,action) => {
            state.user = action.payload
            localStorage.setItem('token', action.payload.idToken)
        })
    }
  })

  export const { logOutAction, setAuthMode} = authSlice.actions

  export default authSlice.reducer