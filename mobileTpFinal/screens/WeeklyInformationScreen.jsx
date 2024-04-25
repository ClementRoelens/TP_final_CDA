import { View, Text, TextInput, Pressable, StyleSheet, ScrollView } from 'react-native'
import HeaderInformationComponent from "../components/HeaderInformationComponent"
import Button from '../components/Button'
import { useSelector } from 'react-redux'
import CalendarButton from '../components/CalendarButton'


const WeeklyInformationScreen = ({navigation}) => {
    const employee = useSelector(state => state.employee.employee);

    const weeklyOvertime = () => {

    }

    return (
        <View>
            <HeaderInformationComponent/>
           
                <ScrollView horizontal={true}>
                    <View style={styles.card}>
                        <Text style={styles.cardText}>Card 1</Text>
                    </View>
                    <View style={styles.card}>
                        <Text style={styles.cardText}>Card 2</Text>
                    </View>
                    <View style={styles.card}>
                        <Text style={styles.cardText}>Card 3</Text>
                    </View>
                </ScrollView>

           
            
            
                <Text style={styles.overtimeText}>
                    Exédent : {weeklyOvertime()}
                </Text>
                <CalendarButton></CalendarButton>
                <View style={styles.date}>
                <Button text={"15/04/2024"} heightStyle={"classicHeight"} widthStyle={"mediumWidth"}
                    onPressAction={() => navigation.navigate('DailyInformation')}/>
                </View>
            

        </View>
    )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  cardContainer: {
    flexDirection: 'row',
  },
  card: {
    top:36,
    width: 287,
    height: 358,
    // backgroundColor: 'linear-gradient(135deg, #5764A0, #535A75)',
    backgroundColor: 'blue',
    marginHorizontal: 10, // Ajout de marges horizontales pour l'espacement entre les cartes
    alignItems: 'center',
    justifyContent: 'center',
    borderRadius: 11,
  },
  cardText: {
    fontSize: 20,
    fontWeight: 'bold',
    color: 'white', // Changement de couleur du texte en blanc pour une meilleure lisibilité
  },
  zoneb:{
    top:50,
    textAlign:'center',
    fontSize: 20,
    fontWeight: 'bold',
  },
  overtimeText:{
    top:30,
    textAlign:'center',
    fontSize: 23,
    fontWeight: 'regular',
    color : '#000000',

  },
  date:{
    alignItems: 'center',
    justifyContent: 'center',
    top:100,
    textAlign:'center',
    fontSize: 20,
    fontWeight: 'bold',

  },

});
export default WeeklyInformationScreen

