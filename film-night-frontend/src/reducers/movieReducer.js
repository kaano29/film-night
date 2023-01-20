import {
  GET_MOVIES
} from '../actions/types'

const initialState = {
  movies: []
}


const movieReducer = (state = initialState, action) => {
  const { type, payload } = action
  switch (type) {
    case GET_MOVIES:
      return {...state, movies: payload?.data}
    default:
      return state
  }
}

export default movieReducer
