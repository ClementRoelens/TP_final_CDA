import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native'
import HomeScreen from './screens/HomeScreen';
import { Provider } from 'react-redux';
import { store } from './store';
import EmployeeScreen from './screens/EmployeeScreen';
import DailyInformationScreen from './screens/DailyInformationScreen.jsx';
import WeeklyInformationScreen from './screens/WeeklyInformationScreen.jsx'

const Stack = createNativeStackNavigator();

function App() {

  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator screenOptions={{ headerShown: false }}>
          <Stack.Screen name="Home" component={HomeScreen} />
          <Stack.Screen name="Employee" component={EmployeeScreen} />
          <Stack.Screen name="DailyInformation" component={DailyInformationScreen} />
          <Stack.Screen name="WeeklyInformation" component={WeeklyInformationScreen} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}



export default App;
