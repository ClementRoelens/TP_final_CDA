import CercleWithLogo from "./CercleWithLogo"
import imageAdmin from "../../assets/logo-admin.png"
import { useNavigate } from "react-router-dom"
import { useDispatch } from "react-redux"
import styles from "../../style/Header.module.css"
import logo from "../../assets/logo.jpg";

const Header = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate();

    const disconnectClick = () => {
        dispatch(logOutAction())
        navigate("/")
    }

    return(
        <>
        <div className={styles.header}>
            <CercleWithLogo diameter="9.77vh" imageUrl={logo}/>
            <div className={styles.rightSection}>
                <button className={styles.button} onClick={() => disconnectClick()}>Déconnexion</button>
                <img src={imageAdmin} alt="admin"></img>
            </div>
        </div>

        </>
    )
}

export default Header