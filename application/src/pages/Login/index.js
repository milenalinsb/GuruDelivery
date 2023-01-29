import React from 'react'
import LargeButton from '../../components/LargeButton'
import './style.css'

export default function Login() {
  return (
    <>
      <div className='container' >
        <div className='login-container'>


          <div className='login-header'>
            <div className='login-header-logo'>
              Guru Delivery
            </div>
            <div className='login-header-text'>
              Use suas credenciais para realizar o login.
            </div>
          <hr style={{width: '100%', marginTop: '50px'}}/>
          </div>

          <div className='login-form'>
            <form>
              <input type="email" placeholder='Digite o seu e-mail'/>
              <input type="password" placeholder='Digite sua senha'/>
              <LargeButton text="Enviar" bg/>
              <hr style={{width: '100%', marginTop: '50px'}}/>
            </form>
          </div>

          <div className='login-footer'>
            <LargeButton text="Quero me Cadastrar"/>
          </div>
        </div>
      </div>
    </>
  )
}
