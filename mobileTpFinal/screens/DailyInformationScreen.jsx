import { ScrollView, Text } from "react-native"
import HeaderInformationComponent from "../components/HeaderInformationComponent"
import Button from "../components/Button"
import { useSelector } from 'react-redux'



const DailyInformationScreen = ({navigation}) => {
    const employee = useSelector(state => state.employee.employee);



    return (
        <ScrollView>
            <HeaderInformationComponent/>
            <Text>coucou</Text>
            <Button text={"Semaine"} heightStyle={"largeHeight"} 
    onPressAction={() => stamp()}/>        </ScrollView>
    )
}

  

export default DailyInformationScreen