import React from 'react'
import Footer from '../Footer/Footer'
import Navbar from '../Navbar/Navbar'

const Layout = ({children}) => {
  return (
    <>
    <Navbar />
    <div className="layout">

    {children}
    </div>
    <Footer />
    </>
  )
}

export default Layout