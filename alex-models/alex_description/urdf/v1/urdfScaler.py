import re
from xml.etree import ElementTree as ET

ORIGINAL_URDF = "alex_v1.rlModel_nubForearms_robotAccurate_torsoFootCollisions.urdf"
SCALED_URDF_NAME = "mini_alex_v1_nubForearms.urdf"

S = 0.05
M_SCALE = S**3        # 0.000125
I_SCALE = S**5        # 3.125e-7

INERTIAL_TAGS = {"ixx", "ixy", "ixz", "iyy", "iyz", "izz"}
XYZ_ATTRS = {"xyz"}
SIZE_ATTRS = {"size", "radius", "length"}  # geometry / box / cylinder
MASS_TAG = "mass"
ORIGIN_TAG = "origin"
INERTIAL_ELEM = "inertial"

def scale_xyz(val: str):
    parts = re.split(r"[ \t]+", val.strip())
    scaled = []
    for p in parts:
        if not p:
            continue
        v = float(p)
        scaled.append(f"{v * S:.8g}")
    return " ".join(scaled)

def scale_size(val: str):
    parts = re.split(r"[ \t]+", val.strip())
    scaled = []
    for p in parts:
        if not p:
            continue
        v = float(p)
        scaled.append(f"{v * S:.8g}")
    return " ".join(scaled)

def scale_urdf(in_path, out_path):
    tree = ET.parse(in_path)
    root = tree.getroot()

    # Scale origins, geometry, inertials
    for elem in root.iter():
        # 1) origin xyz (but not rpy)
        if elem.tag == ORIGIN_TAG and "xyz" in elem.attrib:
            elem.set("xyz", scale_xyz(elem.attrib["xyz"]))

        # 2) geometry size / radius / length
        for attr in list(elem.attrib.keys()):
            if attr in SIZE_ATTRS:
                elem.set(attr, scale_size(elem.attrib[attr]))

        # 3) inertial blocks: mass + inertia + origin xyz
        if elem.tag == INERTIAL_ELEM:
            for child in elem:
                # mass
                if child.tag == MASS_TAG and "value" in child.attrib:
                    m = float(child.attrib["value"])
                    child.set("value", f"{m * M_SCALE:.8g}")
                # inertia tensor
                if child.tag == "inertia":
                    for k in INERTIAL_TAGS:
                        if k in child.attrib:
                            iv = float(child.attrib[k])
                            child.set(k, f"{iv * I_SCALE:.8g}")

    tree.write(out_path, encoding="utf-8", xml_declaration=True)

if __name__ == "__main__":
    scale_urdf(ORIGINAL_URDF, SCALED_URDF_NAME)
