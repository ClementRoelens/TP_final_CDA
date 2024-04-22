import { View, Text, TextInput, Pressable, StyleSheet } from 'react-native'
import React from 'react'
import GuestHeaderComponent from '../components/GuestHeaderComponent'
import Button from '../components/Button'

const Home = () => {
  return (
    <View>
      <GuestHeaderComponent/>
      <View style={styles.overall}>
        <TextInput placeholder="abc@example.com" autoComplete="email"/>
        <TextInput placeholder="****" autoComplete="password" secureTextEntry/>
        <Button text={"Se connecter"} />
        <Pressable>
            <Text style={styles.pressableText}>Mot de passe oublié</Text>
        </Pressable>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
    overall:{
        display:"flex",
        flexDirection:"column",
        justifyContent:"center"
    },
    pressableText : {
            textDecorationLine : "underline"
    }
});

export default Home