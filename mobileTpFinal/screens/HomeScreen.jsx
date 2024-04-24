import { View, Text, TextInput, Pressable, StyleSheet, ScrollView } from 'react-native'
import React, { useRef, useState } from 'react'
import GuestHeaderComponent from '../components/GuestHeaderComponent'
import Button from '../components/Button'
import InputAndLabel from '../components/InputAndLabel'
import { useDispatch } from 'react-redux'
import { signin } from '../components/employeeSlice'

const Home = ({navigation}) => {
  const dispatch = useDispatch();
  const [emailValue,setEmailValue] = useState("");
  const [passwordValue,setPasswordValue] = useState("");
  const [isFailed, setIsFailed] = useState(false);

  async function onSignin(){
    if (emailValue !== "" && passwordValue !== ""){
      const result = await dispatch(signin({
        email : emailValue,
        password : passwordValue
      }));
      if (!result.error){
        navigation.navigate('Employee')
      } else {
        setIsFailed(true);
      }
    }
  }

  return (
    <ScrollView style={styles.mainContainer}>
      <GuestHeaderComponent/>
      <View style={styles.form}>
        <InputAndLabel label={"Email :"} placeholder={"abd@example.com"} stateValueSetter={setEmailValue} />
        <InputAndLabel label={"Mot de passe :"} placeholder={"*****"} isSecure={true} stateValueSetter={setPasswordValue} />
        <Button text={"Se connecter"} onPressAction={() => onSignin()} />
        {isFailed && <Text style={styles.fail}>La connexion a échoué</Text>}
        <Pressable>
            <Text style={styles.pressableText}>Mot de passe oublié</Text>
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
        textDecorationLine : "underline",
        textAlign:"center",
        color:"#0E0E0E"
    },
    fail :{
      textAlign:"center",
      fontSize:17,
      color:"red"
    }
});

export default Home