import React from 'react'
import Footer from '../Footer/Footer'
import Navbar from '../Navbar/Navbar'

const Layout = ({children}) => {
  return (
    <div style={{marginTop: "130px"}}>
    <Navbar />
    <div className="layout">

    {children}
    </div>
    <Footer />
    </div>
  )
}

export default Layout