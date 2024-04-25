const Button = (props) => {
    const {heightStyle, widthStyle, text,onClickAction} = props

    const buttonStyle = {
        height: heightStyle,
        width: widthStyle,
        backgroundColor : "#4C63CA",
        borderRadius: "7px",
        color: "var(--white)", 
        fontFamily: "var(--font-sans-serif)", 
        fontSize:"1.5em",
        fontWeight: "medium", 
        textAlign: "center", 
        border:"none",
        cursor:"pointer"
    };

    return(
        <button style={buttonStyle} onClick={onClickAction}>{text}</button>
    )
}

export default Button