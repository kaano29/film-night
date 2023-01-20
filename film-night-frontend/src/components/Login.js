import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { useNavigate } from "react-router-dom";
import { getUserByUsername } from "../actions/user";
import { useDispatch } from "react-redux";
import bcrypt from 'bcryptjs'
import { GET_USER, USER_LOGIN_SUCCESS } from "../actions/types";

export default function Login() {

  const navigate = useNavigate()
  const dispatch = useDispatch()

  const handleSubmit = async (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    await dispatch(getUserByUsername(data.get("username"))).then(res => {
      const hashedPassword = res.data.password
      const salt = hashedPassword.substring(0, 29)
      const enteredHashedPassword = bcrypt.hashSync(data.get('password'), salt)
      if(enteredHashedPassword === hashedPassword) {
        dispatch({
          type: USER_LOGIN_SUCCESS,
          payload: res.data
        });
        navigate('/movies')
      }
    })
  }

    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline/>
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon/>
          </Avatar>
          <Typography component="h1" variant="h5">
            Login
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="Username"
              name="username"
              autoComplete="username"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Login
            </Button>
            <Grid item>
              <Link sx={{ cursor: "pointer" }} onClick={() => navigate("/signup")}>
                {"Don't have an account? Sign Up"}
              </Link>
            </Grid>
          </Box>
        </Box>
      </Container>
    );
  }