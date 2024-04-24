import { ScrollView, Text } from "react-native"
import HeaderInformationComponent from "../components/HeaderInformationComponent"
import Button from "../components/Button"



const DailyInformationScreen = ({navigation}) => {



    return (
        <ScrollView>
            <HeaderInformationComponent/>
            <Text>coucou</Text>
            <Button text={"Semaine"} heightStyle={"largeHeight"} 
    onPressAction={() => stamp()}/>        </ScrollView>
    )
}

  

export default DailyInformationScreen