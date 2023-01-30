import './NavBar.css'
import logo from '../assets/logo-black.svg'




export default function NavBar() {



    return (
        <div >
            <nav className="navbar bg-body-tertiary ">
                <div className="container ">
                    <a className="navbar-brand" href="">
                        <img src={logo} alt="logo" />
                    </a>
                </div>

            </nav >
            <div id='navbar-style'> </div>

        </div >
    )

}