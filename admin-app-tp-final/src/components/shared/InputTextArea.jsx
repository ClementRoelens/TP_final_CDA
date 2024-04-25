const InputTextArea = (props) => {
    const { heightStyle, widthStyle, placeholder, type, onChangeAction } = props

    const inputStyle = {
        height: heightStyle,
        width: widthStyle,
        borderRadius: "12px",
        color: "#EBEBEB",
        fontWeight: "light",
        textAlign: "left",
        padding: "10px",
        boxSizing: "border-box",
        border : "none"
    };

    return (
        <input
            style={inputStyle}
            placeholder={placeholder}
            onChange={onChangeAction}
            type={type}
        />
    );
}
export default InputTextArea