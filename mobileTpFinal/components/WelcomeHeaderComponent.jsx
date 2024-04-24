import { Image, StyleSheet ,Text} from 'react-native'
import React from 'react'
import LinearGradient from 'react-native-linear-gradient';

const WelcomeHeaderComponent = () => {
    return (
        <LinearGradient colors={['#5764A0', '#535A75']} style={styles.background}>
            {/* <Text>Bienvenue {employee.firstName + " " + employee.lastName}</Text> */}
            <Image source={require("../assets/basicPhoto.jpg")} style={styles.logo} />
        </LinearGradient>
    )
}

const styles = StyleSheet.create({
    background: {
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

export default WelcomeHeaderComponent