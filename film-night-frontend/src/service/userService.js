import axios from 'axios'

const API_URL = 'https://film-night-backend-1673962682438.azurewebsites.net'

export const createUserApi = async (user) => {
  try {
    const res = await axios.post(API_URL + '/api/v1/users', user);
    return res;
  } catch (err) {
    throw err.response;
  }
}

export const getUserByUsernameApi = async (username) => {
  try {
    const res = await axios.get(API_URL + '/api/v1/users/' + username);
    return res;
  } catch (err) {
    throw err.response;
  }
}

