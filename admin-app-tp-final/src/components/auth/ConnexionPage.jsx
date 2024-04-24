import { useDispatch, useSelector } from "react-redux"
import Button from "../shared/Button"
import CercleWithLogo from "../shared/CercleWithLogo"
import InputTextArea from "../shared/InputTextArea"
import { useNavigate } from "react-router-dom"
import { useRef } from "react"
import { setAuthMode, signInAction, signUpAction } from "./authSlice"
import image from '../../assets/logo.jpg'

// import imageUrl from './assets/logo'


const ConnexionPage = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate()
    const authMode = useSelector(state => state.auth.authMode)
    const emailRef = useRef()
    const passwordRef = useRef()

    const pathImage = image

    const buttonProps = {
        heightStyle: "102px",
        widthStyle: "386px",
        text: authMode === "Se connecter" ? "Se connecter" : "Réinitialiser" ,
        onClickAction: () => {
            if(authMode === "Se connecter") {
                dispatch(signInAction())
            } else if(authMode === "Réinitialiser") {
                dispatch(signUpAction())
            }
        },
    };

    const inputEmailProps = {
        heightStyle: "82px",
        widthStyle: "270px",
        text: "abc@email.com",
        onChangeAction: (event) => {
            console.log("Contenu de l'input email :", event.target.value);
        },
    };
    
    const inputPasswordProps = {
        heightStyle: "82px",
        widthStyle: "270px",
        text: "********",
        onChangeAction: (event) => {
            console.log("Contenu de l'input password :", event.target.value);
        },
    };

    const circleProps = {
        diameter: "340px",
        imageUrl: pathImage,
    };


    const submitHandler = (event) => {
        event.preventDefault()

        const email = emailRef.current.value
        const password = passwordRef.current.value

        const credentials = {
        email,
        password, 
        returnSecureToken: true
        }

        authMode === "Se connecter" ? dispatch(signInAction(credentials)) : dispatch(signUpAction(credentials))
         navigate('/') /* a adapter */
    }

    const forgetPassword = (event) => {
        event.preventDefault()

            dispatch(setAuthMode(authMode === "Se connecter" ? "S'inscrire" : "Se connecter"))
    }

  return (
    <>
        
        <div>
            <div>
                <CercleWithLogo {...circleProps}></CercleWithLogo>
            </div>
            <div>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsam error, commodi libero sint aperiam cupiditate esse praesentium nihil nisi reprehenderit, assumenda at tempore mollitia quam ea in voluptas. In, ducimus?</p>
            </div>
        </div>
        <div>
        <form onSubmit={submitHandler}>
            <div>
                <label htmlFor="email" className="form-label">Email: </label>
                <InputTextArea ref={emailRef} {... inputEmailProps}></InputTextArea>
            </div>
            <div style={{ display: authMode !== "Se connecter" ? 'none' : 'block' }}>
                <label htmlFor="password" className="form-label">Mot de passe: </label>
                <InputTextArea ref={passwordRef} {...inputPasswordProps}></InputTextArea>
            </div>
            <div>
                <Button {...buttonProps}></Button>
            </div>
        </form>
        {authMode === "Se connecter" && (
                    <a href="" onClick={forgetPassword} style={{ display: authMode !== "Se connecter" ? 'none' : 'block' }}>Mot de passe oublié</a> 
                    /* Adaptation nécessaire */
                )}
        </div>
    </>
  )
}

export default ConnexionPage

