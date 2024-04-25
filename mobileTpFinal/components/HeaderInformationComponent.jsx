import {StyleSheet ,Text} from 'react-native'
import React from 'react'
import LinearGradient from 'react-native-linear-gradient';
import { useSelector } from 'react-redux'


const HeaderInformationComponent = () => {
    const employee = useSelector(state => state.employee.employee);


    return (
        <LinearGradient colors={['#5764A0', '#535A75']} style={styles.background}>
            <Text style={styles.welcome}>Bienvenue </Text>
            <Text style={styles.name}>{employee.firstName + " " + employee.lastName}</Text>
        </LinearGradient>
    )
}

const styles = StyleSheet.create({
    background: {
        height:185,
        display:"flex",
        justifyContent: "center",
        alignItems:"center"
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

export default HeaderInformationComponent