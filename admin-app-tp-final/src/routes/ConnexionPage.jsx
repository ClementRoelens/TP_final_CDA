import Button from "../components/Button"
import CercleWithLogo from "../components/CercleWithLogo"
import InputTextArea from "../components/InputTextArea"
import classes from './ConnexionPage.css'
// import imageUrl from './assets/logo'

function ConnexionPage() {
    const buttonProps = {
        heightStyle: "102px",
        widthStyle: "386px",
        text: "Se connecter",
        onClickAction: () => {
            console.log("Bouton cliqué !");
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
        imageUrl: imageUrl,
    };
    return (
        
        
        <>
        <Button {...buttonProps}/>
        <InputTextArea {... inputEmailProps} />
        <InputTextArea {... inputPasswordProps} />

        <CercleWithLogo {... circleProps} />


        </>

        
    )
}
export default ConnexionPage