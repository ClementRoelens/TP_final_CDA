import { Image, StyleSheet } from 'react-native'
import React from 'react'
import LinearGradient from 'react-native-linear-gradient';

const GuestHeaderComponent = () => {
    return (
        <LinearGradient colors={['#5764A0', '#535A75']} style={styles.background}>
            <Image source={require("../assets/logo.png")} style={styles.logo} />
        </LinearGradient>
    )
}

const styles = StyleSheet.create({
    background: {
        // background: "linear-gradient(#5764A0, #535A75)",
        height:297,
        display:"flex",
        justifyContent: "center",
        alignItems:"center"
    },
    logo: {
        height: 230,
        width:230
    }
});

export default GuestHeaderComponent