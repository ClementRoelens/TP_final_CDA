import { View, Text, TextInput, Pressable, StyleSheet, ScrollView } from 'react-native'
import React, { useRef } from 'react'
import GuestHeaderComponent from '../components/GuestHeaderComponent'
import Button from '../components/Button'
import InputAndLabel from '../components/InputAndLabel'
import { useDispatch } from 'react-redux'

const Home = () => {
  const dispatch = useDispatch();
  const emailRef = useRef();
  const passwordRef = useRef();

  async function signin(){

  }

  return (
    <ScrollView style={styles.mainContainer}>
      <GuestHeaderComponent/>
      <View style={styles.form}>
        <InputAndLabel label={"Email :"} placeholder={"abd@example.com"} ref={emailRef} />
        <InputAndLabel label={"Mot de passe :"} placeholder={"*****"} isSecure={true} ref={passwordRef} />
        <Button text={"Se connecter"} onPressAction={signin} />
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
    }
});

export default Home