const CercleWithLogo = (props) => {
    const {diameter, imageUrl} = props

    const circleStyle = {
        width: diameter,
        height: diameter,
        borderRadius: "50%", // Pour créer un cercle
        overflow: "hidden", // Pour cacher les parties de l'image en dehors du cercle
        position: "relative", // Pour positionner l'image à l'intérieur du cercle
    };

    const imageStyle = {
        width: "100%",
        height: "auto",
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
    }

    return (
        <div style={circleStyle}>
            <img src={imageUrl} alt="Contenu" style={imageStyle} />
        </div>
    );

}

export default CercleWithLogo