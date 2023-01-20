import {
  CREATE_USER, CREATE_USER_ERROR, SET_MESSAGE, USER_LOGIN_SUCCESS,
} from '../actions/types'

const initialState = {
  username: "",
  avatar: "",
  favoriteMovies: []
}

const userReducer = (state = initialState, action) => {
  const { type, payload } = action
  switch (type) {
    case CREATE_USER:
      return { ...state, response: payload.response }
    case CREATE_USER_ERROR:
      return { ...state, response: payload.response}
    case USER_LOGIN_SUCCESS:
      return { ...state, username: payload.username, avatar: payload.avatar, favoriteMovies: payload.favoriteMovies }
    default:
      return state
  }
}

export default userReducer
