import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { getAuthorizationHeadersValue } from "../helpers/jwtHeadersProvider";

const API_Employee = "http://localhost:8090/api"

async function addAttendanceToEmployee(employee){
    const response = await fetch(`${API_Employee}/attendance/isPresent/${employee.id}`,{
      headers: {
        "Authorization": getAuthorizationHeadersValue()
      }
    });
    const attendance = await response.text();
    return (attendance === "Présent");
}

export const fetchEmployeesAction = createAsyncThunk(
  "employees/fetchEmployeesAction",
  async () => {
    const response = await fetch(`${API_Employee}/employees`, {
      headers: {
        "Authorization": getAuthorizationHeadersValue()
      }
    });

    const employees = await response.json();
    
    employees.map(async employee => {
      const e = await addAttendanceToEmployee(employee)
      return e;
    });

    return employees;
  }
)

const addEmployeeAction = createAsyncThunk(
  "employees/addEmployeeAction",
  async (employee, { getState }) => {
    const token = localStorage.getItem('token')
    if (token) {
      const response = await fetch(`${API_Employee}employees.json?auth=${token}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
      })
      const data = await response.json()

      return { id: data.id, ...employee }
    }
  }
)

export const deleteEmployeeAction = createAsyncThunk(
  'employees/deleteEmployeeAction',
  async (employeeId, { getState }) => {
    const token = localStorage.getItem('token')
    if (token) {
      const response = await fetch(`${API_Employee}employees/${employeeId}.json?auth=${token}`, {
        method: "DELETE"
      })

      return employeeId
    }
  }
)

export const editEmployeeAction = createAsyncThunk(
  "employees/editEmployeeAction",
  async ({ id, ...employee }, { getState }) => {
    const token = localStorage.getItem('token')
    if (token) {
      const response = await fetch(`${API_Employee}employees/${id}.json?auth=${token}`, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
      })

      const data = await response.json()

      return { id, ...data }
    }
  }
)

const employeesSlice = createSlice({
  name: "employees",
  initialState: {
    employees: [],
    formMode: "",
    isLoading: false,
    error: null,
    selectedEmployee: null
  },
  reducers: {
    setFormMode: (state, action) => {
      state.formMode = action.payload
    },
    setSelectedEmployee: (state, action) => {
      state.selectedEmployee = action.payload
    }
  },
  extraReducers: (builder) => {
    builder.addCase(fetchEmployeesAction.pending, (state) => {
      state.isLoading = true
      state.error = null
      state.employees = []
    })

    builder.addCase(fetchEmployeesAction.rejected, (state, action) => {
      state.isLoading = false
      state.error = action.payload
      console.error(action.error);
    })

    builder.addCase(fetchEmployeesAction.fulfilled, (state, action) => {
      state.isLoading = false
      state.employees = action.payload
    })

    builder.addCase(deleteEmployeeAction.fulfilled, (state, action) => {
      state.employees = state.employees.filter(a => a.id !== action.payload)
    })

    builder.addCase(addEmployeeAction.fulfilled, (state, action) => {
      state.employees.push(action.payload)
    })

    builder.addCase(editEmployeeAction.fulfilled, (state, action) => {
      state.employees = [...state.employees.filter(a => a.id !== action.payload.id), action.payload]
    })
  }
})

export const { setFormMode, setSelectedEmployee } = employeesSlice.actions
export default employeesSlice.reducer