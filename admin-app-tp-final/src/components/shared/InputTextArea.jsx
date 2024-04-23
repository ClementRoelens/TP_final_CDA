const InputTextArea = (props) => {
const {heightStyle, widthStyle, placeholder,onChangeAction} = props

const inputStyle = {
    height: heightStyle,
    width: widthStyle,
    backgroundColor : "#707899",
    borderRadius: "12px",
    color: "#EBEBEB", 
    fontFamily: "Inter", 
    fontWeight: "light", 
    textAlign: "left", 
    padding: "10px",
    boxSizing: "border-box",
};

return (
    <input 
        style={inputStyle} 
        placeholder={placeholder} 
        onChange={onChangeAction} 
    />
);
}
export default InputTextArea