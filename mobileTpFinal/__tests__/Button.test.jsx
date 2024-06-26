import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react-native';
import Button from './Button';

describe("Test du component Button", () => {

  it("Est rendu", () => {
    render(<Button text="Confirmer"/>);
    const button = screen.getByText("Confirmer");
    expect(button).toBeDefined();
  });

  it("Action bien exécutée", () => {
    const action = jest.fn();

    render(<Button onPressAction={action} text="Bouton" />);
    const button = screen.getByText
    fireEvent.press(button)

    expect(action).toHaveBeenCalled();
  })

  it("Style heightStyle par défaut", () => {
    render(<Button text="Confirmer"/>);
    const button = screen.getByText("Confirmer");

    const styles = button.parent.props.style;
    const heightStyle = buttonStyles.find(style => style.height === 72);

    expect(heightStyle).toBeDefined();
  })

});


function Example() {
    const [name, setUser] = React.useState('')
    const [show, setShow] = React.useState(false)
  
    return (
      <View>
        <TextInput value={name} onChangeText={setUser} testID="input" />
        <Button
          title="Print Username"
          onPress={() => {
            // let's pretend this is making a server request, so it's async
            // (you'd want to mock this imaginary request in your unit tests)...
            setTimeout(() => {
              setShow(true)
            }, Math.floor(Math.random() * 200))
          }}
        />
        {show && <Text testID="printed-username">{name}</Text>}
      </View>
    )
  }
  
  test('examples of some things', async () => {
    const expectedUsername = 'Ada Lovelace'
  
    render(<Example />)
  
    fireEvent.changeText(screen.getByTestId('input'), expectedUsername)
    fireEvent.press(screen.getByText('Print Username'))
  
    // Using `findBy` query to wait for asynchronous operation to finish
    const usernameOutput = await screen.findByTestId('printed-username')
  
    // Using `toHaveTextContent` matcher from `@testing-library/jest-native` package.
    expect(usernameOutput).toHaveTextContent(expectedUsername)
  
    expect(screen.toJSON()).toMatchSnapshot()
  })