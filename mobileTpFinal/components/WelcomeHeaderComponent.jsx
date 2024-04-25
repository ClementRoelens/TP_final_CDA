import { Image, StyleSheet ,Text} from 'react-native'
import React from 'react'
import LinearGradient from 'react-native-linear-gradient';
import { useSelector } from 'react-redux'



const WelcomeHeaderComponent = (props) => {
    const employee = useSelector(state => state.employee.employee);

    return (
        <LinearGradient colors={['#5764A0', '#535A75']} style={styles.background}>
            <Text style={styles.welcome}>Bienvenue </Text>
            <Text style={styles.name}>{employee.firstName + " " + employee.lastName}</Text>
            <Image source={employee.photoPath} style={styles.photo} />
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
    photo: {
        width: 150,
        height: 150,
        borderRadius: 75, 
        overflow: "hidden" ,
        position: "absolute",
        top: 135
    },
    welcome: {
        position: "absolute",
        top: 20,
        fontSize:19,
        color : "#EBEBEB",
    },
    name: {
        position: "absolute",
        color : "#EBEBEB",
        top : 80,
        fontFamily : "Inter",
        fontSize: 38,
        fontWeight : "medium"
    }
});

export default WelcomeHeaderComponent