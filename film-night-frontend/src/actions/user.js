import { createUserApi, getUserByUsernameApi } from '../service/userService';
import { CREATE_USER_ERROR, CREATE_USER, GET_USER, GET_USER_ERROR } from './types'

export const createUser = (user) => async (dispatch) => {
  try {
    const res = await createUserApi(user);
    dispatch({
      type: CREATE_USER,
      payload: res
    });
    return res
  } catch (err) {
    dispatch({
      type: CREATE_USER_ERROR,
      payload: err
    });
    return err
  }
}

export const getUserByUsername = (username) => async (dispatch) => {
  try {
    const res = await getUserByUsernameApi(username);
    dispatch({
      type: GET_USER,
      payload: res
    });
    return res
  } catch (err) {
    dispatch({
      type: GET_USER_ERROR,
      payload: err
    });
    return err
  }
}

