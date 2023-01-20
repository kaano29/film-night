import { applyMiddleware, combineReducers, compose, legacy_createStore as createStore } from 'redux'
import thunkMiddleware from 'redux-thunk'
import userReducer from "./reducers/userReducer";
import { devToolsEnhancer } from 'redux-devtools-extension';
import movieReducer from "./reducers/movieReducer";

const rootReducer = combineReducers({
  userReducer,
  movieReducer
})

const enhancer = compose(
  applyMiddleware(thunkMiddleware),
  devToolsEnhancer()
);

const store = createStore(rootReducer, enhancer);
export default store;