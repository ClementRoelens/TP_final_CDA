import { View, Text ,ScrollView,StyleSheet,Pressable} from 'react-native'
import React from 'react'
import Button from '../components/Button'
import { useSelector } from 'react-redux'
import WelcomeHeaderComponent from '../components/WelcomeHeaderComponent';

const EmployeeScreen = () => {
    const employee = useSelector(state => state.employee.employee);
    console.log("employé : ", employee)

  return (
    <ScrollView style={styles.mainContainer}>

    <WelcomeHeaderComponent></WelcomeHeaderComponent>
    <View style={styles.form}>
    <Button text={"Emploi du temps"} widthStyle={"small"} heightStyle={"classicHeight"}/>
    <Button text={"Pointer"} heightStyle={"largeHeight"}/>
    <Pressable>
            <Text style={styles.pressableText}>J'ai fait une erreur</Text>
        </Pressable>
    </View>
    </ScrollView>
  )
}

const styles = StyleSheet.create({
  mainContainer :{
      // flex:1
  },
  form:{
    marginTop:50,
      flex:1,
      justifyContent:"center",
      alignItems:"center",
      rowGap:35
  },


  pressableText : {
      textAlign:"center",
      color:"#0E0E0E"
  }

});

export default EmployeeScreen