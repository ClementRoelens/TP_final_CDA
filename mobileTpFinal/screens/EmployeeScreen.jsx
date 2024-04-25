import { View, Text ,ScrollView,StyleSheet,Pressable} from 'react-native'
import React, { useEffect } from 'react'
import Button from '../components/Button'
import { useDispatch, useSelector } from 'react-redux'
import WelcomeHeaderComponent from '../components/WelcomeHeaderComponent';
import { clockIn, clockOut, getInitialClockInFromDatabase } from '../components/attendanceSlice';

const EmployeeScreen = ({navigation}) => {
  const dispatch = useDispatch();
    const employee = useSelector(state => state.employee.employee);
    const attendance = useSelector(state => state.attendance.clockIn)

    useEffect(() => {
      if (employee != null){
        dispatch(getInitialClockInFromDatabase());
      }
    },[employee])
    
    async function clock() {
      console.log(attendance);
      if(attendance === null) {
        dispatch(clockIn(Date.now()))
      } else {
        dispatch(clockOut(Date.now()))
      }
    }

  return (
    <View style={styles.mainContainer}>
    <WelcomeHeaderComponent></WelcomeHeaderComponent>
    <View style={styles.form}>
    <Button text={"Emploi du temps"} widthStyle={"small"} heightStyle={"classicHeight"} style={styles.btnempt}
    onPressAction={() => navigation.navigate('WeeklyInformation')}/>
    
    <Button text={"Pointer"} heightStyle={"largeHeight"} 
    onPressAction={() => clock()}/>
   
    <Pressable style={styles.mistake}>
            <Text style={styles.pressableText}>J'ai fait une erreur</Text>
    </Pressable>
    </View>
    </View>
  )
}

const styles = StyleSheet.create({
  mainContainer :{
       flex:1
  },
  form:{
    marginTop:70,
      justifyContent:"center",
      alignItems:"center",
      rowGap:70
  },

  pressableText : {
      textAlign:"center",
      color:"#0E0E0E"
  },
  mistake: {
    top : 50

  }




});

export default EmployeeScreen