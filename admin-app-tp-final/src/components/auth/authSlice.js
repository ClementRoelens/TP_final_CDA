import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { getAuthorizationHeadersValue } from "../../helpers/jwtHeadersProvider";

const API_Employee = "http://localhost:8090/api/employees"

async function getEmployee(email){
  const response = await fetch(`${API_Employee}/byMail/${email}`, {
    method : "GET",
    headers : {
      "Authorization" : getAuthorizationHeadersValue(),
      "Content-Type" : "application/json"
    }
  });

  return await response.json();
}

export const signInAction = createAsyncThunk(
    "auth/signInAction",
    async (credentials) => {
        const response = await fetch(`${API_Employee}/signin`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credentials)
        });

          const jwt = await response.text()
          localStorage.setItem("token",jwt);
          return await getEmployee(credentials.email);
    }
)

export const signUpAction = createAsyncThunk(
    "auth/signUpAction",
    async (credentials) => {
      const response = await fetch(API_Employee, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(credentials)
      })
  
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
          console.log(action.payload)
            state.user = action.payload;
        }),
        builder.addCase(signInAction.rejected, (state,action) => {
          console.error(action.error);
        }),
        builder.addCase(signUpAction.fulfilled, () => {
            console.log("inscription réussie");
        }),   
        builder.addCase(signUpAction.rejected, (state,action) => {
          console.error(action.error);
        })
    }
  })

  export const { logOutAction, setAuthMode} = authSlice.actions

  export default authSlice.reducer