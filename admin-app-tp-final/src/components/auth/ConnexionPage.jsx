import { useDispatch, useSelector } from "react-redux"
import Button from "../shared/Button"
import CercleWithLogo from "../shared/CercleWithLogo"
import InputTextArea from "../shared/InputTextArea"
import { Link, useNavigate } from "react-router-dom"
import { useRef, useState } from "react"
import { setAuthMode, signInAction, signUpAction } from "./authSlice"
import image from '../../assets/logo.jpg'
import styles from '../../style/ConnexionPage.module.css';
// import imageUrl from './assets/logo'


const ConnexionPage = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const authMode = useSelector(state => state.auth.authMode)

    const [emailValue, setEmailValue] = useState("");
    const [passwordValue, setPasswordValue] = useState("");
    const [isFailed, setIsFailed] = useState(false);

    const pathImage = image

    const buttonProps = {
        heightStyle: "10vh",
        widthStyle: "26.83vw",
        text: authMode === "Se connecter" ? "Se connecter" : "Réinitialiser"
    };

    const inputEmailProps = {
        heightStyle: "8.02vh",
        widthStyle: "18.61vw",
        text: "abc@email.com",
        type: "text",
        onChangeAction: (event) => {
            setEmailValue(event.target.value);
        },
    };

    const inputPasswordProps = {
        heightStyle: "8.02vh",
        widthStyle: "18.61vw",
        text: "********",
        type: "password",
        onChangeAction: (event) => {
            setPasswordValue(event.target.value);
        },
    };

    const circleProps = {
        diameter: "340px",
        imageUrl: pathImage,
    };


    const submitHandler = async (event) => {
        event.preventDefault()

        const credentials = {
            email: emailValue,
            password: passwordValue
        }

        if (authMode === "Se connecter") {
            const response = await dispatch(signInAction(credentials));
            if (!response.error) {
                navigate("/listEmployee");
            } else {
                setIsFailed(true);
            }
        } else {
            const response = await dispatch(signUpAction(credentials));
            if (!response.error) {
                dispatch(setAuthMode("S'inscrire"));
                navigate("/");
            } else {
                setIsFailed(true);
            }
        }

    }

    const forgetPassword = (event) => {
        event.preventDefault()

        dispatch(setAuthMode(authMode === "Se connecter" ? "S'inscrire" : "Se connecter"))
    }

    return (
        <div className={styles.pageContainer}>
            <div className={styles.leftSection}>
                <CercleWithLogo {...circleProps}></CercleWithLogo>
                <div className={styles.heroText} >
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsam error, commodi libero sint aperiam cupiditate</p>
                </div>
            </div>
            <form onSubmit={submitHandler} className={styles.rightSection}>
                <div className={styles.inputArea}>
                    <label htmlFor="email" className="form-label">Email: </label>
                    <InputTextArea {...inputEmailProps}></InputTextArea>
                </div>
                <div className={styles.inputArea} style={{display : authMode === "Se connecter" ? "flex" : "none"}}>
                    <label htmlFor="password" className="form-label">Mot de passe: </label>
                    <InputTextArea {...inputPasswordProps}></InputTextArea>
                </div>
                {isFailed &&
                    <p>{authMode === "Se connecter" ? "Connexion échouée, vos informations doivent être erronées" : "L'inscription a échoué"}</p>
                }
                <div>
                    <Button {...buttonProps}></Button>
                </div>
                {authMode === "Se connecter" && (
                    <button className={styles.plainButton} onClick={forgetPassword} style={{ display: authMode !== "Se connecter" ? 'none' : 'block' }}>Mot de passe oublié</button>
                    /* Adaptation nécessaire */
                )}
            </form>
        </div>

    )
}

export default ConnexionPage

