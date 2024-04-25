import { createBrowserRouter } from "react-router-dom";
import ConnexionPage from "./components/auth/ConnexionPage";
import FormAddEmployee from"./routes/FormAddEmployee";
import ForgotPasswordPage from"./routes/ForgotPasswordPage.jsx";
import ListEmployeePage from"./routes/ListEmployeePage";
import EmployeeDetailsPage from"./routes/EmployeeDetailsPage";
import ProtectedRoute from './components/shared/ProtectedRoute.jsx'
import App from "./App";




const router = createBrowserRouter([
    {
        path : "/",
        element : <App />,
        children : [
            {
                path : "/",
                element : <ConnexionPage />
            },
            {
                path : "/form",
                element :<ProtectedRoute><FormAddEmployee /></ProtectedRoute> 
            },
            {
                path : "/forgotPassword",
                element : <ForgotPasswordPage />
            },
            {
                path : "/listEmployee",
                element : <ProtectedRoute><ListEmployeePage /></ProtectedRoute>
            },
            {
                path : "/employeeDetails",
                element : <ProtectedRoute><EmployeeDetailsPage /></ProtectedRoute>
            }
        ]
    }

    // {
    //     path : "/",
    //     element : <ConnexionPage />
    // },
    // {
    //     path : "/form",
    //     element : <FormAddEmployee />
    // },
    // {
    //     path : "/listEmployee",
    //     element : <ListEmployeePage />
    // },
    
])

export default router