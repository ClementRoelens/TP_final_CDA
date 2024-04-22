import { createBrowserRouter } from "react-router-dom";
import ConnexionPage from "./routes/ConnexionPage";


const router = createBrowserRouter([
    {
        path : "/",
        element : <ConnexionPage />
    }
])

export default router