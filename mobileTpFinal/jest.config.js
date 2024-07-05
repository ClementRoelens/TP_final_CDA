module.exports = {
  preset: 'react-native',
  setupFilesAfterEnv: [
    '@testing-library/jest-native/extend-expect'
  ],
  transform: {
    '^.+\\.(js|jsx|ts|tsx)$': ['babel-jest', { rootMode: 'upward' }],
  },
  transformIgnorePatterns: [
    '/node_modules/(?!(foo|bar)/)', 
    '/bar/',
    "node_modules/(?!(jest-)?react-native|@react-native|@react-navigation|@react-native/js-polyfills)",
    "node_modules/@react-native/js-polyfills/error-guard\\.js"
  ],
  moduleNameMapper: {
    '^@react-native/js-polyfills/error-guard\\.js$': '<rootDir>/__mocks__/error-guard-mock.js',
  },
  
};