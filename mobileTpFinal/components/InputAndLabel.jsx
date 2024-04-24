import { View, Text, TextInput, StyleSheet } from 'react-native'
import React from 'react'

const InputAndLabel = ({ label, placeholder, isSecure, stateValueSetter }) => {
    return (
        <View>
            <Text style={styles.text}>{label}</Text>
            <TextInput 
                placeholderTextColor={"#EBEBEB"} 
                placeholder={placeholder} 
                secureTextEntry={isSecure} 
                style={styles.input} 
                onChangeText={(text) => stateValueSetter(text)} />
        </View>
    )
};

const styles = StyleSheet.create({
    text: {
        marginLeft:15,
        marginBottom:15,
        color: "#0E0E0E"
    },
    input: {
        backgroundColor: "#707899",
        width: 220,
        borderRadius: 12,
        padding: 15,
        color : "#EBEBEB",
        // Drop shadows à factoriser
        shadowColor: '#000',
        shadowOffset: {
          width: 4, 
          height: 2,
        },
        shadowOpacity: 0.35, 
        shadowRadius: 3.5, 
        elevation: 3, 
    }
});

export default InputAndLabel