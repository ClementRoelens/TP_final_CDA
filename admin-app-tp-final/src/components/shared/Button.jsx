const Button = (props) => {
    const {heightStyle, widthStyle, text,onClickAction} = props

    const buttonStyle = {
        height: heightStyle,
        width: widthStyle,
        backgroundColor : "#4C63CA",
        borderRadius: "7px",
        color: "#FFFFFF", 
        fontFamily: "Inter", 
        fontWeight: "medium", 
        textAlign: "center", 
    };

    return(
        <button style={buttonStyle} onClick={onClickAction}>{text}</button>
    )
}

export default Button