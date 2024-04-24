import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native'
import Home from './screens/Home';
import { Provider } from 'react-redux';
import { store } from './store';

const Stack = createNativeStackNavigator();

function App() {

  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator screenOptions={{ headerShown: false }}>
          <Stack.Screen name="Home" component={Home} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}



export default App;
