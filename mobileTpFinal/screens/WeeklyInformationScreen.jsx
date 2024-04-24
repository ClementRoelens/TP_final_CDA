import { ScrollView, Text } from "react-native"
import HeaderInformationComponent from "../components/HeaderInformationComponent"
import Button from '../components/Button'


const WeeklyInformationScreen = ({navigation}) => {

    return (
        <ScrollView>
            <HeaderInformationComponent/>
            <Text>coucou</Text>

            <Button text={"15/04/2024"} heightStyle={"classicHeight"} widthStyle={"mediumWidth"}
    onPressAction={() => navigation.navigate('DailyInformation')}/>
        </ScrollView>
    )
}


export default WeeklyInformationScreen

