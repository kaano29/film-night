import { getMoviesApi } from "../service/movieService";
import { GET_MOVIES, GET_MOVIES_ERROR } from "./types";

export const getMovies = () => async (dispatch) => {
  try {
    const res = await getMoviesApi();
    dispatch({
      type: GET_MOVIES,
      payload: res
    });
    return res
  } catch (err) {
    dispatch({
      type: GET_MOVIES_ERROR,
      payload: err
    });
    return err
  }
}