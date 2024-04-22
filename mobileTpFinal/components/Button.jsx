import { View, Text, StyleSheet, Pressable } from 'react-native'
import React from 'react'

const Button = ({ heightStyle, widthStyle, text, onPressAction }) => {
    const buttonStyle = {
        ...styles.background,
        ...(heightStyle === "large" ? styles.largeHeight : styles.classicHeight),
        ...(widthStyle === "small" ? styles.smallWidth :
                                    widthStyle === "medium" ? styles.mediumWidth : styles.largeWidth)};

    return (
        <Pressable style={buttonStyle} onPress={onPressAction}>
                <Text style={styles.text}>{text}</Text>
        </Pressable>
    )
}

const styles = StyleSheet.create({
    background: {
         backgroundColor : "#4C63CA",
         display:"flex",
         justifyContent:"center",
         alignContent:"center",
         borderRadius:8
        },
        text :{
            color:"#EBEBEB",
            fontWeight:"400",
            fontSize:27,
            textAlign:"center"
    },
    classicHeight: {
        height: 72
    },
    largeHeight: {
        height: 86
    },
    smallWidth: {
        width: 250
    },
    mediumWidth: {
        width: 287
    },
    largeWidth: {
        width: 317
    }
});

export default Button