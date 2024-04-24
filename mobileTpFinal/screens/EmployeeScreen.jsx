import { View, Text } from 'react-native'
import React from 'react'
import { useSelector } from 'react-redux'

const EmployeeScreen = () => {
    const employee = useSelector(state => state.employee.employee);
    console.log("employé : ", employee)

  return (
    <View>
      <Text>Bonjour {employee.firstName + " " + employee.lastName}</Text>
    </View>
  )
}

export default EmployeeScreen