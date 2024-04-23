import CercleWithLogo from "./CercleWithLogo"
import imageAdmin from "../../assets/imageAdmin.jpg"
import { useNavigate } from "react-router-dom"
import { useDispatch } from "react-redux"

const Header = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate();

    const disconnectClick = () => {
        dispatch(logOutAction())
        navigate("/")
    }
    return(
        <>
        <div>
            <CercleWithLogo></CercleWithLogo>
            <button onClick={() => disconnectClick()}>Déconnexion</button>
            <img src={imageAdmin} alt="admin"></img>
            
        </div>

        </>
    )
}

export default Header